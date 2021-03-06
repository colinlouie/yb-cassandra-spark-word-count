name := "CassandraSparkWordCount"
version := "1.0"
scalaVersion := "2.11.12"
scalacOptions := Seq("-unchecked", "-deprecation")

val sparkVersion = "2.4.4"

// https://mvnrepository.com/artifact/com.yugabyte.spark/spark-cassandra-connector
libraryDependencies += "com.yugabyte.spark" %% "spark-cassandra-connector" % "2.4-yb"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % Provided

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % Provided
