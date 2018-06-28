package pl.com.sages.spark

import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.DStream

/**
  * Run: nc -lk 9999
  */
object NetworkTCPStreaming extends BaseSparkStreamingApp with GlobalParameters {

  def main(args: Array[String]) {

    val ssc = createStreamingContext

    val lines: DStream[String] = ssc.socketTextStream(hostname, port.toInt, StorageLevel.MEMORY_AND_DISK_SER)
    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)

    wordCounts.print()
    wordCounts.count().print()

    ssc.start()
    ssc.awaitTermination()
  }

}