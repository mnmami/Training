# 1. 'Read' a file to an RDD
val sql = sc.textFile("Person.sql")

# 2. 'Filter' all lines and keep the one containing "INSERT INTO"
val lines = sql.filter(_.contains("INSERT INTO"))

# 3. Remove the string "INSERT INTO `person` VALUES (" 
# As "INSERT INTO `person` VALUES (" has 29 charecter, we 'map' each INSERT line to a new line skipping the first 29 charecters
val lines1 = lines.map(l =>l.substring(29))

# 4. 'Drop' the two charecters ");" from the end (right) of each line
val lines2 = lines1.map(l =>l.dropRight(2))

# 5. Map each line to multiple lines (using 'flatMap'), splitting the line on the string "____" (4 underscores)
val lines3 = lines2.flatMap(l => l.split("____"))

import org.apache.spark.sql._
import org.apache.spark.sql.types._

# 6. Create a 'structure' (schema)
val fields = Seq(StructField("nr", IntegerType, nullable = true), StructField("name", StringType, nullable = true), StructField("mbox_sha1sum", StringType, nullable = true), StructField("country", StringType, nullable = true), StructField("publisher", IntegerType, nullable = true), StructField("publishDate", DateType, nullable = true))

val schema = StructType(fields)

# 7. Create a 'ROW' RDD
# As we have a date field, we create a date format
val format = new java.text.SimpleDateFormat("yyyy-MM-dd")

# We map each line from step 5 to a row
val rowRDD = lines3.map(_.split(",")).map(attributes => Row(attributes(0).toInt, attributes(1), attributes(2), attributes(3), attributes(4).toInt, java.sql.Date.valueOf(attributes(5).replace("'",""))))
 
 # 8. Create a DataFrame by applying the schema to the rows RDD
 # Write the results of the slaves to one file using `coalesce(1)`
 # Include the header using `option("header","true")`
 personsDF.coalesce(1).write.option("header","true").csv("Person.csv")
