package com.AssignmentTwoSearchEngine;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class IndexAnkita {


    private final static Path currentRelativePath = Paths.get("").toAbsolutePath();
    
    private final static String absPathToIndex = String.format("index", currentRelativePath);
    private final static String absPathToFedRegister = String.format("../documents/fr94",currentRelativePath);
    private final static String absPathToForBroadcast = String.format("../documents/fbis",currentRelativePath);
    private final static String absPathToFinTimes = String.format("../documents/ft",currentRelativePath);
    private final static String absPathToLATimes = String.format("../documents/latimes",currentRelativePath);
    
    static Analyzer analyzer = new CustomAnalyzer();
    static Similarity similarity = new BM25Similarity();
//    static Similarity similarity = new LMDirichletSimilarity();

    
    public static void main(String[] args) throws IOException {
    	buildDocsIndex();
    }

    public static void loadForBroadcastDocs(String pathToForBroadcast) throws IOException {
    	
        IndexWriter indexWriter;
        IndexWriterConfig indexWriterConfig  = new IndexWriterConfig(analyzer);
        indexWriterConfig
                .setSimilarity(similarity)
                .setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        Directory drct = FSDirectory.open(Paths.get(absPathToIndex));
        indexWriter = new IndexWriter(drct, indexWriterConfig);
    	
        File[] directories = new File(pathToForBroadcast).listFiles(File::isDirectory);
        System.out.println(directories);
        String docno,text,title;
        
        File[] files = new File(pathToForBroadcast).listFiles();
        for (File file : files) {
            org.jsoup.nodes.Document d = Jsoup.parse(file, null, "");
            Elements documents = d.select("doc");

            for (Element document : documents) {
                docno = document.select("docno").text();
                text = document.select("text").text();
                title = document.select("ti").text();
                
                Document doc = new Document();
                doc.add(new TextField("DOCNO", docno, Field.Store.YES));
                doc.add(new TextField("TITLE", title, Field.Store.YES));
                doc.add(new TextField("TEXT", text, Field.Store.YES));
                indexWriter.addDocument(doc);
            }
        }
        indexWriter.close();
        drct.close();
    }



    public static void loadLaTimesDocs(String pathToLATimesRegister) throws IOException {

        IndexWriter indexWriter;
        IndexWriterConfig indexWriterConfig  = new IndexWriterConfig(analyzer);
        indexWriterConfig
                .setSimilarity(similarity)
                .setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        Directory drct = FSDirectory.open(Paths.get(absPathToIndex));
        indexWriter = new IndexWriter(drct, indexWriterConfig);

        File folder = new File(pathToLATimesRegister);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {

            org.jsoup.nodes.Document laTimesContent = Jsoup.parse(file, null, "");

            Elements docs = laTimesContent.select("DOC");

            for(Element doc: docs) {
                String docNo, headline, text;
                docNo = (doc.select("DOCNO").text());
                headline = (doc.select("HEADLINE").text());
                text = (doc.select("TEXT").text());
                org.apache.lucene.document.Document document = new org.apache.lucene.document.Document();
                document.add(new TextField("DOCNO", docNo, Field.Store.YES));
                document.add(new TextField("TITLE", headline, Field.Store.YES) );
                document.add(new TextField("TEXT", text, Field.Store.YES) );
                indexWriter.addDocument(document);
            }
        }
        indexWriter.close();
        drct.close();
    }


    public static void loadFedRegisterDocs(String pathToFedRegister) throws IOException {
        IndexWriter indexWriter;
        IndexWriterConfig indexWriterConfig  = new IndexWriterConfig(analyzer);
        indexWriterConfig
                .setSimilarity(similarity)
                .setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        Directory drct = FSDirectory.open(Paths.get(absPathToIndex));
        indexWriter = new IndexWriter(drct, indexWriterConfig);
        File[] directories = new File(pathToFedRegister).listFiles(File::isDirectory);
        String docno,text,title;
        for (File directory : directories) {
            File[] files = directory.listFiles();
            for (File file : files) {
                org.jsoup.nodes.Document d = Jsoup.parse(file, null, "");
                Elements documents = d.select("DOC");

                for (Element document : documents) {
                    docno = document.select("DOCNO").text();
                    text = document.select("TEXT").text();
                    title = document.select("DOCTITLE").text();
                    Document doc = new Document();
                    doc.add(new TextField("DOCNO", docno, Field.Store.YES));
                    doc.add(new TextField("TEXT", text, Field.Store.YES));
                    doc.add(new TextField("TITLE", title, Field.Store.YES));
                    indexWriter.addDocument(doc);
                }
            }
        }
        indexWriter.close();
        drct.close();
    }


    public static void loadFinTimesDocs(String pathToFinTimes) throws IOException {
    	
//    	System.out.println(currentRelativePath);
        IndexWriter indexWriter;
        IndexWriterConfig indexWriterConfig  = new IndexWriterConfig(analyzer);
        indexWriterConfig
                .setSimilarity(similarity)
                .setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        Directory drct = FSDirectory.open(Paths.get(absPathToIndex));
        indexWriter = new IndexWriter(drct, indexWriterConfig);
        File[] directories = new File(pathToFinTimes).listFiles(File::isDirectory);
        System.out.println(directories);
        String docno,text,title;
        for (File directory : directories) {
            File[] files = directory.listFiles();
            for (File file : files) {
                org.jsoup.nodes.Document d = Jsoup.parse(file, null, "");
                Elements documents = d.select("DOC");

                for (Element document : documents) {
                    docno = document.select("DOCNO").text();
                    text = document.select("TEXT").text();
                    title = document.select("HEADLINE").text();
                    Document doc = new Document();
                    doc.add(new TextField("DOCNO", docno, Field.Store.YES));
                    doc.add(new TextField("TITLE", title, Field.Store.YES));
                    doc.add(new TextField("TEXT", text, Field.Store.YES));
                    indexWriter.addDocument(doc);
                }
            }
        }
        indexWriter.close();
        drct.close();
    }


    public static void buildDocsIndex() throws IOException {
    	
    	System.out.println("Start");
		loadFedRegisterDocs(absPathToFedRegister);
    	System.out.println("Start");
		loadForBroadcastDocs(absPathToForBroadcast);
    	System.out.println("Start");
		loadFinTimesDocs(absPathToFinTimes);
    	System.out.println("Start");
		loadLaTimesDocs(absPathToLATimes);
    	System.out.println("Done");

    }
}