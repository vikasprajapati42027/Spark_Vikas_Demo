package RDDBasic

import org.apache.spark.sql.SparkSession

object CSVwithDF {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder()
      .config("spark.eventLog.enabled", "true")
      .config("spark.eventLog.dir", "file:///tmp/spark-events")
      .config("spark.history.fs.logDirectory", "file:///tmp/spark-events")
      .appName("Creating data frame with csv file")
      .master("local")
      .getOrCreate()

    val csv = "src/main/resources/house_prices.csv"

    val csvRDD = sparkSession.sparkContext.textFile(csv, 20)

    csvRDD.take(10).foreach(println)

    csvRDD.saveAsTextFile("src/main/resources/output/house_price_op1")




  }
}
