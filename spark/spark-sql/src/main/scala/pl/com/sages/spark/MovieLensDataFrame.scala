package pl.com.sages.spark

import org.apache.spark.sql.SparkSession

object MovieLensDataFrame extends GlobalSqlParameters {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder.appName(this.getClass.getSimpleName).getOrCreate()
    import spark.implicits._

    // reading from HDFS
    val moviesDataFrame = spark.read.
      option("header", "false").
      option("charset", "UTF8").
      option("delimiter", movielensSeparator).
      option("inferSchema", "true").
      csv(moviesPath).
      withColumnRenamed("_c0", "movieId").
      withColumnRenamed("_c1", "title").
      withColumnRenamed("_c2", "genres")

    val ratingsDataFrame = spark.read.
      option("header", "false").
      option("charset", "UTF8").
      option("delimiter", movielensSeparator).
      option("inferSchema", "true").
      csv(ratingsPath).
      withColumnRenamed("_c0", "userId").
      withColumnRenamed("_c1", "movieId").
      withColumnRenamed("_c2", "rating").
      withColumnRenamed("_c3", "timestamp")

    // show
    moviesDataFrame.show(10)

    // SQL ;)
    moviesDataFrame.printSchema()
    moviesDataFrame.select("title").show()
    moviesDataFrame.groupBy("genres").count().show()
    moviesDataFrame.filter($"title".contains("2005")).show()

    moviesDataFrame.createOrReplaceTempView("movies")
    spark.sql("SELECT * FROM movies").show()

    // transform
    moviesDataFrame.map(movie => "Movie: " + movie(1)).show()

    // aggregation
    val resultDF = ratingsDataFrame.
      groupBy("movieId").
      avg("rating").
      as("r").
      join(moviesDataFrame.as("m"), $"m.movieId" === $"r.movieId")

    resultDF.show
    resultDF.printSchema()

    // end
    spark.stop()
  }

}