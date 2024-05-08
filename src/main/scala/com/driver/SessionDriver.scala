package com.driver

import org.apache.commons.configuration.PropertiesConfiguration
import org.apache.spark.sql.SparkSession

object SessionDriver {

  // Create spark session
  def sparkSession(sparkName: String)(implicit config: PropertiesConfiguration): SparkSession = {
    SparkSession.builder().appName(sparkName)
      .config("spark.sql.shuffle.partitions", config.getInt("spark_shuffle"))
      .config("spark.default.parallelism", config.getInt("spark_paralellism"))
      .config("spark.dynamicAllocation.enabled", "false")
      .enableHiveSupport().getOrCreate()
  }
}
