package com.AssignmentTwoSearchEngine;

import org.apache.lucene.analysis.CharArraySet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is used to provide various constants to be used across the sample application
 */
public class LuceneConstants
{


    public static final List<String> stopWords = new ArrayList<>(
            Arrays.asList("a", "an", "and", "are", "as", "at", "about", "above", "after", "again", "against", "all", "am",
                    "any", "aren't", "because", "be", "but", "by", "been", "before", "being", "below", "between",
                    "can't", "cannot", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during",
                    "each", "few", "for", "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd",
                    "he'll", "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's",
                    "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's",
                    "me", "more", "most", "mustn't", "my", "myself", "no", "nor", "of", "off", "on", "once", "only", "or", "other",
                    "ought", "our", "ours", "ourselves", "such", "that", "the", "their", "then", "there", "these", "they", "this", "to", "was",
                    "will", "with", "how", "what", "were", "why", "where", "you", "your", "yours", "yourself", "yourselves", "she", "them", "which", "who", "whom", 
                    "themselves", "those", "until", "not", "can", "should", "now", "than", "too", "very", "some", "same", "up", "while", "just", "through", "out", "over", "own", "under", "when", "both", "i.e.", "much", "so")
            
                                  
            
    );
    public static final CharArraySet stopWordsSet = new CharArraySet(stopWords, true);
    //Field names
    public static final String TITLE = "title";

    public static final String PUBLISHER = "publisher";
    public static final String DATE = "date";
    public static final String DOCUMENT_NUMBER = "document_number";
    public static final String PROFILE = "profile";
    public static final String HEADLINE = "HEADLINE";
    public static final String TEXT = "TEXT";
    public static final String PAGE = "page";
    public static final String BYLINE = "byline";
    public static final String DATE_LINE = "date_line";

    public static final String HT = "ht";
    public static final String AU = "au";
    public static final String HEADER = "header";
//    public static final String TEXT_5 = "text5";
    public static final String HEADING = "heading";
//    public static final String HEADING_1 = "heading1";
//    public static final String HEADING_2 = "heading2";
//    public static final String HEADING_3 = "heading3";
//    public static final String HEADING_4 = "heading4";
//    public static final String HEADING_5 = "heading5";
//    public static final String HEADING_6 = "heading6";
//    public static final String HEADING_7 = "heading7";
//    public static final String HEADING_8 = "heading8";
    public static final String ABS = "abs";
    public static final String FIGURE = "figure";
    public static final String TR = "tr";

    public static final String PARENT = "parent";
    public static final String FURTHER = "further";
//    public static final String SUPPLEMENTARY_INFO = "supplementary_info";
    public static final String SIGNER = "signer";
    public static final String SIGN_JOB = "sign_job";
    public static final String FR_FILING = "fr_filing";
    public static final String BILLING = "billing";
    public static final String FOOTNOTE = "footnote";
    public static final String ADDRESS = "address";
    public static final String FOOTCITE = "footcite";
    public static final String AGENCY = "agency";
    public static final String ACTION = "action";
    public static final String SUMMARY = "summary";
    public static final String RINDOCK = "rindock";
    public static final String US_DEPARTMRNT = "us_department";
    public static final String US_BUREAU = "us_bureau";
    public static final String CFRNO = "cfrno";

    public static final String DOCUMENT_ID = "DOCNO";
    public static final String SECTION = "section";
    public static final String LENGTH = "length";
    public static final String SUBJECT = "subject";
    public static final String CORRECTION_DATE = "correction_date";
    public static final String CORRECTION = "correction";
    public static final String GRAPHIC = "graphic";
    public static final String TABLE = "table";
    
    
    
    
}
