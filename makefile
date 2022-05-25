run: build
	java -cp target

build: ./src/main/java/com/arctos6135/revivify/lib/*.java
	javac -d target --source-path ./src/main/java/ ./src/main/java/com/arctos6135/revivify/lib/*.java
