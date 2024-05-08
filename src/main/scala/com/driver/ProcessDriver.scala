package com.driver

import com.data.DataProcess
import org.apache.commons.configuration.PropertiesConfiguration
import org.apache.spark.sql.SparkSession

object ProcessDriver {
  // Run process
  def submit(implicit spark: SparkSession, config: PropertiesConfiguration): Unit = {
    DataProcess.process.run()
  }
}
