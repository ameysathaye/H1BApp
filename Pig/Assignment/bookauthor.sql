book_info = Load '/home/hduser/book.txt' USING PigStorage(',') as (book_id:int,price:int,Author_ID:int);

book_info_filtered = FILTER book_info BY price>=200;

author_info = Load '/home/hduser/author.txt' USING PigStorage(',') as (Author_ID:int,Author_name:chararray);

author_info_filtered = FILTER author_info BY INDEXOF(Author_name,'J',0)==0;

book_author_info = JOIN book_info_filtered BY Author_ID,author_info_filtered BY Author_ID;

final = foreach book_author_info generate $1,$2,$4;

store final  into '/home/hduser/niit/pig/bookauthor' using PigStorage('|');
