
(cd AssignmentTwoSearchEngine/ &&
mvn package &&
java -cp target/AssignmentTwoSearchEngine-1.0-SNAPSHOT.jar com.AssignmentTwoSearchEngine.IndexAnkita &&
java -cp target/AssignmentTwoSearchEngine-1.0-SNAPSHOT.jar com.AssignmentTwoSearchEngine.Queries)
    
(cd trec_eval-9.0.7/ &&
./trec_eval -m all_trec ../documents/qrels2 ../AssignmentTwoSearchEngine/results > ../AssignmentTwoSearchEngine/trecResults)

