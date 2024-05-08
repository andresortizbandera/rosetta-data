package com

import org.apache.commons.configuration.PropertiesConfiguration
import org.apache.spark.sql.SparkSession
import com.data.Fields.properties
import com.driver.ProcessDriver
import com.driver.SessionDriver.sparkSession

object Main {

  def main(args: Array[String]): Unit = {
    val sparkName: String = "DataProcess"
    implicit val config: PropertiesConfiguration = new PropertiesConfiguration(properties)
    implicit val spark: SparkSession = sparkSession(sparkName)
    ProcessDriver.submit(spark, config)
  }
}
