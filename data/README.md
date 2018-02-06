# E-Commerce data
- This data is generated using BSBM benchmark.
- It is altered for the purpose of the training, the string "),(" used by the INSER clause (INSERT INTO ... VALUES (),(),(),...) is replaced with "____", as there was a problem detected while SSHing to Vagrant box, the backslash can't be typed (all symbols needing to press Alt can't be produced). 
- Schema of the data is as follows:
  Vendor(nr, label, comment, homepage, country, publisher, publishDate)
  Offer(nr, product, producer, vendor, price, validFrom, validTo, deliveryDays, offerWebpage, publisher, publishDate)
  Person(nr, name, mbox_sha1sum, country, publisher, publishDate)
  Review(nr, product, producer, person, reviewDate, title, text, language, rating1, rating2, rating3, rating4, 
   publisher, publishDate)
