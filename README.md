# Use Scala to perform a Spark word-count using Cassandra as the input source.

This was ported from:

https://docs.yugabyte.com/latest/develop/ecosystem-integrations/apache-spark/

based on content as of March 24, 2020.

# This is totally different from the Java version!

This example was not ported with 100% code-design parity in mind.

On purpose:
- Example file is in repo root, versus src/main/scala/.
- Everything is in the main function so you could read it linearly.
- Logging was left out.
- Reading options from command line was left out, and related items thereof.

It was written with the same order of execution, with additional use-cases
where applicable.

1. Create Cassandra tables.
2. Load prerequisite data.
3. Read from Cassandra table as DataFrame.

   This part differed from the Java example as the Java example loaded it as
   an RDD. I chose to load it as a DataFrame because DataFrames are
   essentially an RDD wrapped with a Schema.

4. Perform Word Count.
   1. By using the RDD object from the DataFrame.
   2. By using the DataFrame directly.
5. Save to Cassandra table.
   1. From RDD.
   2. From DataFrame.

# Build the application

To build the fat JAR, run the following command.

`$ sbt assembly`

# Running the Spark word-count sample application

```
$ spark-submit --class com.yugabyte.sample.apps.CassandraSparkWordCount \
    target/scala-2.11/CassandraSparkWordCount-assembly-1.0.jar
```

You should see the following as the output.

Due to the parallel nature of Apache Spark, the row order may differ on each
run. The contents should be exactly the same though.

```
+-----+-----+
| word|count|
+-----+-----+
|  two|    2|
|eight|    8|
|seven|    7|
| four|    4|
|  one|    1|
|  six|    6|
|  ten|   10|
| nine|    9|
|three|    3|
| five|    5|
+-----+-----+
```
