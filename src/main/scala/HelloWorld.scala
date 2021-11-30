import org.apache.spark.sql.SparkSession

object HelloWorld {
 def main(args: Array[String]): Unit =
 {
   val sparkSession = SparkSession.builder().appName("Creating first app").master("local")
     .getOrCreate()

  val array = Array(1,2,3,4,5,6,7,8,9,0)

  val RDDarray = sparkSession.sparkContext.parallelize(array)

  RDDarray.foreach(println)
 }
}
