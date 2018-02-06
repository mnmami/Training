# 1. Offer
val rowRDD = lines4.map(l => Row(l(0).toString.toInt, l(1).toString.toInt, l(2).toString.toInt, l(3).toString.toInt, l(4).toString.toDouble, java.sql.Date.valueOf(l(5).toString.replace("'","")), java.sql.Date.valueOf(l(6).toString.replace("'","")), l(7).toString.toInt, l(8).toString, l(9).toString.toInt, java.sql.Date.valueOf(l(10).toString.replace("'",""))))

val fields = Seq(StructField("nr", IntegerType, nullable = true), StructField("product", IntegerType, nullable = true), StructField("producer", IntegerType, nullable = true), StructField("vendor", IntegerType, nullable = true), StructField("price", DoubleType, nullable = true), StructField("validFrom", DateType, nullable = true), StructField("validTo", DateType, nullable = true), StructField("deliveryDays", IntegerType, nullable = true), StructField("offerWebpage", StringType, nullable = true), StructField("publisher", IntegerType, nullable = true), StructField("publishDate", DateType, nullable = true))
 
 # 2. Person
 val rowRDD = lines3.map(_.split(",")).map(attributes => Row(attributes(0).toInt, attributes(1), attributes(2), attributes(3), attributes(4).toInt, java.sql.Date.valueOf(attributes(5).replace("'",""))))

 val fields = Seq(StructField("nr", IntegerType, nullable = true), StructField("name", StringType, nullable = true), StructField("mbox_sha1sum", StringType, nullable = true), StructField("country", StringType, nullable = true), StructField("publisher", IntegerType, nullable = true), StructField("publishDate", DateType, nullable = true))

# 3. Producer
val rowRDD = lines4.map(l => Row(l(0).toString.toInt, l(1).toString, l(2).toString, l(3).toString, l(4).toString, l(5).toString.toInt, java.sql.Date.valueOf(l(6).toString.replace("'",""))))

val fields = Seq(StructField("nr", IntegerType, nullable = true), StructField("label", StringType, nullable = true), StructField("comment", StringType, nullable = true), StructField("homepage", StringType, nullable = true), StructField("country", StringType, nullable = true), StructField("publisher", IntegerType, nullable = true), StructField("publishDate", DateType, nullable = true))

# 4. Product
var linesA = lines4.map(l => if(l(4)=="null") Array(l(0),l(1),l(2),l(3),-1,l(5),l(6),l(7),l(8),l(9),l(10),l(11),l(12),l(13),l(14),l(15),l(16),l(17)) else l)
linesA = linesA.map(l => if(l(5)=="null") Array(l(0),l(1),l(2),l(3),l(4),-1,l(6),l(7),l(8),l(9),l(10),l(11),l(12),l(13),l(14),l(15),l(16),l(17)) else l)
linesA = linesA.map(l => if(l(6)=="null") Array(l(0),l(1),l(2),l(3),l(4),l(5),-1,l(7),l(8),l(9),l(10),l(11),l(12),l(13),l(14),l(15),l(16),l(17)) else l)
linesA = linesA.map(l => if(l(7)=="null") Array(l(0),l(1),l(2),l(3),l(4),l(5),l(6),-1,l(8),-1,l(10),l(11),l(12),l(13),l(14),l(15),l(16),l(17)) else l)
linesA = linesA.map(l => if(l(8)=="null") Array(l(0),l(1),l(2),l(3),l(4),l(5),l(6),l(7),-1,l(9),l(10),l(11),l(12),l(13),l(14),l(15),l(16),l(17)) else l)
linesA = linesA.map(l => if(l(9)=="null") Array(l(0),l(1),l(2),l(3),l(4),l(5),l(6),l(7),l(8),-1,l(10),l(11),l(12),l(13),l(14),l(15),l(16),l(17)) else l)
linesA = linesA.map(l => if(l(16)=="null") Array(l(0),l(1),l(2),l(3),l(4),l(5),l(6),l(7),l(8),l(8),l(10),l(11),l(12),l(13),l(14),l(15),-1,l(17)) else l)

val rowRDD = linesA.map(l => Row(l(0).toString.toInt, l(1), l(2), l(3).toString.toInt, l(4).toString.toInt, l(5).toString.toInt, l(6).toString.toInt, l(7).toString.toInt, l(8).toString.toInt, l(9).toString.toInt, l(10).toString, l(11).toString, l(12).toString, l(13).toString, l(14).toString, l(15).toString, l(16).toString.toInt, java.sql.Date.valueOf(l(17).toString.replace("'",""))))

val fields = Seq(StructField("nr", IntegerType, nullable = true), StructField("label", StringType, nullable = true), StructField("comment", StringType, nullable = true), StructField("producer", IntegerType, nullable = true), StructField("propertyNum1", IntegerType, nullable = true), StructField("propertyNum2", IntegerType, nullable = true), StructField("propertyNum3", IntegerType, nullable = true), StructField("propertyNum4", IntegerType, nullable = true), StructField("propertyNum5", IntegerType, nullable = true), StructField("propertyNum6", IntegerType, nullable = true), StructField("propertyTex1", StringType, nullable = true), StructField("propertyTex2", StringType, nullable = true), StructField("propertyTex3", StringType, nullable = true), StructField("propertyTex4", StringType, nullable = true), StructField("propertyTex5", StringType, nullable = true), StructField("propertyTex6", StringType, nullable = true), StructField("publisher", IntegerType, nullable = true), StructField("publishDate", DateType, nullable = true))

# 5. Review
var linesA = lines4.map(l => if(l(8)=="null") Array(l(0),l(1),l(2),l(3),l(4),l(5),l(6),l(7),-1,l(9),l(10),l(11),l(12),l(13)) else l)
linesA = linesA.map(l => if(l(9)=="null") Array(l(0),l(1),l(2),l(3),l(4),l(5),l(6),l(7),l(8),-1,l(10),l(11),l(12),l(13)) else l)
linesA = linesA.map(l => if(l(10)=="null") Array(l(0),l(1),l(2),l(3),l(4),l(5),l(6),l(7),l(8),l(9),-1,l(11),l(12),l(13)) else l)
linesA = linesA.map(l => if(l(11)=="null") Array(l(0),l(1),l(2),l(3),l(4),l(5),l(6),l(7),l(8),l(9),l(10),-1,l(12),l(13)) else l)

val rowRDD = linesA.map(l => Row(l(0).toString.toInt, l(1).toString.toInt, l(2).toString.toInt, l(3).toString.toInt, java.sql.Date.valueOf(l(4).toString.replace("'","")), l(5).toString, l(6).toString, l(7).toString, l(8).toString.toInt, l(9).toString.toInt, l(10).toString.toInt, l(11).toString.toInt, l(12).toString.toInt, java.sql.Date.valueOf(l(13).toString.replace("'",""))))

val fields = Seq(StructField("nr", IntegerType, nullable = true), StructField("product", IntegerType, nullable = true), StructField("producer", IntegerType, nullable = true), StructField("person", IntegerType, nullable = true), StructField("reviewDate", DateType, nullable = true), StructField("title", StringType, nullable = true), StructField("text", StringType, nullable = true), StructField("language", StringType, nullable = true), StructField("rating1", IntegerType, nullable = true), StructField("rating2", IntegerType, nullable = true), StructField("rating3", IntegerType, nullable = true), StructField("rating4", IntegerType, nullable = true), StructField("publisher", IntegerType, nullable = true), StructField("publishDate", DateType, nullable = true))
