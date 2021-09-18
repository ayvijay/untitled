import org.apache.spark.sql.SparkSession

package object gfjmlkl {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.master("local[*]").appName("gfjmlkl").getOrCreate()
    //    val ssc = new StreamingContext(spark.sparkContext, Seconds(10))
    val sc = spark.sparkContext

    import spark.implicits._
    import spark.sql
    val data = "C:\\BigData\\Datasets\\bank-full.csv"
    val df = spark.read.format("csv").option("header","true").option("delimiter",";")
      .option("inferSchema","true").load(data)
    df.createOrReplaceTempView("tab")
    val res = spark.sql("select * from tab")
    df.show()
    spark.stop()
  }

}
