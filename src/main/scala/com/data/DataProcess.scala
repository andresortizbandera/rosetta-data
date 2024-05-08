package com.data

import org.apache.commons.configuration.PropertiesConfiguration
import org.apache.spark.sql.{DataFrame, SparkSession}
import com.data.Fields._


class DataProcess {
  def run()(implicit spark: SparkSession, config: PropertiesConfiguration): Unit = {
  // Create all task dataframes
  val dataT1: Seq[(String, String, String, String, String, String)] = Seq(
    ("1", "Juan", "Accounting", "MA", "ES", "2023-09-19"),
    ("2", "Pablo", "Data", "S", "FR", "2023-09-19"),
    ("3", "Tomas", "Human Resources", "M", "EN", "2023-09-19"),
    ("4", "Roberto", "IT", "B", "ES", "2023-09-19"),
    ("5", "Miguel", "M&A", "BI", "VE", "2023-09-19"))
  val expectedT1: DataFrame = spark.createDataFrame(Seq(
    ("1", "Juan", "Accounting", "Málaga", "España", "2023-09-19"),
    ("2", "Pablo", "Data", "Santander", "Francia", "2023-09-19"),
    ("3", "Tomas", "Human Resources", "Madrid", "Inglaterra", "2023-09-19"),
    ("4", "Roberto", "IT", "Barcelona", "España", "2023-09-19"),
    ("5", "Miguel", "M&A", "Bilbao", "Venezuela", "2023-09-19")))
    .toDF(id, name, department, city, country, dataDatePart)
    val inputT2: DataFrame = spark.createDataFrame(Seq(
      ("1", "Maths", "3.5", "Paula Ruiz Ponce", "2011-2012"),
      ("2", "Physics", "5.0", "Antonio Fernandez Cala", "2011-2012"),
      ("3", "Spanish", "6.0", "Felix Prini Baez", "2011-2012"),
      ("4", "Maths", "4.0", "Elena Leal Morales", "2011-2012"),
      ("5", "Biology", "8.5", "Belen Santamaria Mata", "2011-2012"),
      ("6", "Latin", "2.0", "Samuel Zamora Garcia", "2011-2012"),
      ("7", "Maths", "5.5", "Pablo Castillo Caro", "2012-2013"),
      ("8", "Physics", "4.5", "Ramon Blesa Escalona", "2012-2013"),
      ("9", "French", "9.5", "Javier Salas Marquez", "2012-2013"),
      ("10", "Maths", "9.0", "Jorge Morillo Martin", "2012-2013"),
      ("11", "Biology", "4.5", "Alvaro Ruiz Jimenes", "2012-2013"),
      ("12", "French", "7.0", "Estela Pavon Marin", "2012-2013")))
      .toDF(id, subject, mark, fullName, className)
    val expectedT2: DataFrame = spark.createDataFrame(Seq(
      ("2", "Physics", "5.0", "Antonio Fernandez Cala", "2011-2012"),
      ("3", "Spanish", "6.0", "Felix Prini Baez", "2011-2012"),
      ("5", "Biology", "8.5", "Belen Santamaria Mata", "2011-2012"),
      ("7", "Maths", "5.5", "Pablo Castillo Caro", "2012-2013"),
      ("9", "French", "9.5", "Javier Salas Marquez", "2012-2013"),
      ("10", "Maths", "9.0", "Jorge Morillo Martin", "2012-2013"),
      ("12", "French", "7.0", "Estela Pavon Marin", "2012-2013")))
      .toDF(id, subject, mark, fullName, className)
    val expectedFailT2: DataFrame = spark.createDataFrame(Seq(
      ("1", "Maths", "3.5", "Paula Ruiz Ponce", "2011-2012"),
      ("4", "Maths", "4.0", "Elena Leal Morales", "2011-2012"),
      ("6", "Latin", "2.0", "Samuel Zamora Garcia", "2011-2012"),
      ("8", "Physics", "4.5", "Ramon Blesa Escalona", "2012-2013"),
      ("11", "Biology", "4.5", "Alvaro Ruiz Jimenes", "2012-2013")))
      .toDF(id, subject, mark, fullName, className)
    val inputT2_2: DataFrame = spark.createDataFrame(Seq(
      ("1", "Maths", "3.5", "Paco Ruiz Lago", "2011-2012"),
      ("2", "Physics", "5.0", "Felix Prini Baez", "2011-2012"),
      ("3", "Spanish", "6.0", "Felix Prini Baez", "2011-2012"),
      ("4", "Maths", "4.0", "Elena Leal Morales", "2011-2012"),
      ("5", "Biology", "8.5", "Belen Santamaria Mata", "2011-2012"),
      ("6", "Latin", "2.0", "Samuel Zamora Garcia", "2011-2012"),
      ("7", "Maths", "5.5", "Paula Ruiz Ponce", "2012-2013"),
      ("8", "Physics", "4.5", "Ramon Blesa Escalona", "2012-2013"),
      ("9", "French", "9.5", "Javier Salas Marquez", "2012-2013"),
      ("10", "Maths", "9.0", "Jorge Morillo Martin", "2012-2013"),
      ("11", "Biology", "4.5", "Paula Ruiz Ponce", "2012-2013"),
      ("12", "French", "7.0", "Estela Pavon Marin", "2012-2013")))
      .toDF(id, subject, mark, fullName, className)
    val expectedT2_2 = Seq("Paula Ruiz Ponce", "Paco Ruiz Lago")
    val inputT3: DataFrame = spark.createDataFrame(Seq(
      ("1", "6245607513", "Malaga", "0386", "21874301P", "2023-05-12"),
      ("2", "1283973874", "Madrid", "2287", "21874301P", "2023-05-12"),
      ("3", "0987252925", "Valencia", "0872", "21874301P", "2023-05-12"),
      ("4", "2937638976", "Bilbao", "2847", "21874301P", "2023-05-12"),
      ("5", "7239657623", "Barcelona", "1038", "21874301P", "2023-05-12"),
      ("6", "2786527574", "A Coruña", "0983", "21874301P", "2023-05-12"),
      ("7", "9753672337", "Vigo", "4238", "21874301P", "2023-05-12"),
      ("8", "0000237147", "Huelva", "1736", "21874301P", "2023-05-12"),
      ("9", "2738568292", "Burgos", "7926", "21874301P", "2023-05-12"),
      ("10", "1897300000", "Toledo", "7735", "21874301P", "2023-05-12"),
      ("11", "1966732576", "Badajoz", "0027", "21874301P", "2023-05-12"),
      ("12", "1974561473", "Gijon", "8473", "21874301P", "2023-05-12")))
      .toDF(id, clientCode, location, storeId, clientIdCard, dataDatePart)
    val expectedT3: DataFrame = spark.createDataFrame(Seq(
      ("1", "6245607513", "0386", "2023-05-12"),
      ("2", "1283973874", "2287", "2023-05-12"),
      ("3", "0987252925", "0872", "2023-05-12"),
      ("4", "2937638976", "2847", "2023-05-12"),
      ("5", "7239657623", "1038", "2023-05-12"),
      ("6", "2786527574", "0983", "2023-05-12"),
      ("7", "9753672337", "4238", "2023-05-12"),
      ("8", "0000237147", "1736", "2023-05-12"),
      ("9", "2738568292", "7926", "2023-05-12"),
      ("10", "1897300000", "7735", "2023-05-12"),
      ("11", "1966732576", "0027", "2023-05-12"),
      ("12", "1974561473", "8473", "2023-05-12")))
      .toDF(id, clientCode, storeId, dataDatePart)
  }
}

object DataProcess{
  def process()(implicit spark: SparkSession) : DataProcess = {
    new DataProcess()
  }
}
