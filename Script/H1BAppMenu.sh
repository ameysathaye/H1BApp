#!/bin/bash 

show_menu()

{

    NORMAL=`echo "\033[m"`

    MENU=`echo "\033[36m"` #Blue

    NUMBER=`echo "\033[33m"` #yellow

    FGRED=`echo "\033[41m"`

    RED_TEXT=`echo "\033[31m"`

    ENTER_LINE=`echo "\033[33m"`

    echo -e "${MENU}**********************H1B APPLICATIONS***********************${NORMAL}"

    echo -e "${MENU}**${NUMBER} 1) ${MENU} Is the number of petitions with Data Engineer job title increasing over time?${NORMAL}"

    echo -e "${MENU}**${NUMBER} 2) ${MENU} Find top 5 job titles who are having highest growth in applications. ${NORMAL}"

    echo -e "${MENU}**${NUMBER} 3) ${MENU} Which part of the US has the most Data Engineer jobs for each year? ${NORMAL}"

    echo -e "${MENU}**${NUMBER} 4) ${MENU} find top 5 locations in the US who have got certified visa for each year.${NORMAL}"

    echo -e "${MENU}**${NUMBER} 5) ${MENU} Which industry has the most number of Data Scientist positions?${NORMAL}"

    echo -e "${MENU}**${NUMBER} 6) ${MENU} Which top 5 employers file the most petitions each year? ${NORMAL}"

    echo -e "${MENU}**${NUMBER} 7) ${MENU} Find the most popular top 10 job positions for H1B visa applications for each year?${NORMAL}"

    echo -e "${MENU}**${NUMBER} 8) ${MENU} Find the percentage and the count of each case status on total applications for each year. Create a graph depicting the pattern of All the cases over the period of time.${NORMAL}"

    echo -e "${MENU}**${NUMBER} 9) ${MENU} Create a bar graph to depict the number of applications for each year${NORMAL}"

    echo -e "${MENU}**${NUMBER} 10) ${MENU}Find the average Prevailing Wage for each Job for each Year (take part time and full time separate) arrange output in descending order${NORMAL}"

    echo -e "${MENU}**${NUMBER} 11) ${MENU} Which are employers who have the highest success rate in petitions more than 70% in petitions and total petions filed more than 1000?${NORMAL}"

    echo -e "${MENU}**${NUMBER} 12) ${MENU} Which are the top 10 job positions which have the  success rate more than 70% in petitions and total petitions filed more than 1000? ${NORMAL}"

    echo -e "${MENU}**${NUMBER} 13) ${MENU}Export result for option no 12 to MySQL database.${NORMAL}"

    echo -e "${MENU}*********************************************${NORMAL}"

    echo -e "${ENTER_LINE}Please enter a menu option and enter or ${RED_TEXT}enter to exit. ${NORMAL}"

    read opt

}

function option_picked() 

{

    COLOR='\033[01;31m' # bold red

    RESET='\033[00;00m' # normal white

    MESSAGE="$1"  #modified to post the correct option selected

    echo -e "${COLOR}${MESSAGE}${RESET}"

}

clear

show_menu

	while [ opt != '' ]

    do

    if [[ $opt = "" ]]; then 

            exit;

    else

        case $opt in

        1) clear;
        option_picked "1 a) Is the number of petitions with Data Engineer job title increasing over time?";
	        hadoop fs -rm -r /Project/Question1a	
	        hadoop jar dataengineer.jar DataEngineerGrowth /Project/input/h1b.csv /Project/Question1a
                echo -e '\nNumber of Petitions with Data Engineer job each year\n'	
		hadoop fs -cat /Project/Question1a/p*
                show_menu;
        ;;

        2) clear;

        option_picked "1 b) Find top 5 job titles who are having highest growth in applications. ";
                hadoop fs -rm -r /Project/question1b
                pig /home/hduser/question1b.pig
                echo -e '\nDisplay top 5 job titles having highest growth average\n'
                hadoop fs -cat /Project/question1b/p*
                show_menu;
        ;;  

        3) clear;

        option_picked "2 a) Which part of the US has the most Data Engineer jobs for each year?";
		hadoop fs -rm -r /Project/Question2a        
	        hadoop jar dataengineer.jar DataEngineerPart /Project/input/* /Project/Question2a
                echo -e '\nDisplay US part having most Data Engineer job\n'
	        hadoop fs -cat /Project/Question2a/p*	
                show_menu;
        ;;

	    4) clear;

        option_picked "2 b) find top 5 locations in the US who have got certified visa for each year.";
            hive -e "truncate table niit_h1b.question2b;"
            echo -e '\nTable question2b truncated\n'
	    hive -f question2b.sql 
	    echo -e '\nTop 5 location in US having certified visa every year\n'
            hive -e "select * from niit_h1b.question2b;"
            show_menu;
        ;;  

	    5) clear;

        option_picked "3) Which industry has the most number of Data Scientist positions?";
              hadoop fs -rm -r /Project/Question3
              hadoop jar dataengineer.jar DESOC /Project/input/* /Project/Question3 
              echo -e '\nIndustry having most number of Data Scientist\n'
	      hadoop fs -cat /Project/Question3/p*	
              show_menu;
        ;;

        6) clear;

        option_picked "4)Which top 5 employers file the most petitions each year?";
		hadoop fs -rm -r /Project/Question4
                hadoop jar dataengineer.jar DataEngineer /Project/input/* /Project/Question4
                echo -e '\nTop 5 employers filing most petitions each year\n'   
	        hadoop fs -cat /Project/Question4/p*	
                show_menu;
        ;;

        7) clear;

        option_picked "5) Find the most popular top 10 job positions for H1B visa applications for each year?";
                hive -e "truncate table niit_h1b.question5a;"		
                hive -f question5a.sql
                echo -e '\nTop 10 job positions for H1B visa\n'
                hive -e "select * from niit_h1b.question5a;"	
                hive -e "truncate table niit_h1b.question5b;"
                hive -f question5b.sql
                echo -e '\nTop 10 job positions for H1B visa for certified applicants\n'
	        hive -e "select * from niit_h1b.question5b;"
                show_menu;
        ;;

        8) clear;

	option_picked "6) Find the percentage and the count of each case status on total applications for each year. Create a graph depicting the pattern of All the cases over the period of time.";
                pig /home/hduser/question6.pig
                echo -e '\nPercentage and Count of each case status for H1B visa\n'
                hadoop fs -cat /Project/question6/p*
                show_menu;
        ;;

        9) clear;

        option_picked "7) Create a bar graph to depict the number of applications for each year";
		hive -e "select year,count(*) as applications  from niit_h1b.h1b_final group by  year order by year;"
                show_menu;
        ;;

        10) clear;

        option_picked "8) Find the average Prevailing Wage for each Job for each Year (take part time and full time separate) arrange output in descending order";
	        hive -e "truncate table niit_h1b.question8;"
                hive -f question8.sql
                echo -e '\nAverage prevailing wage for each job for each year for full-time employees\n'
                hive -e "select * from niit_h1b.question8 where full_time_position='Y';"
                echo -e '\nAverage prevailing wage for each job for each year for part-time employees\n'
                hive -e "select * from niit_h1b.question8 where full_time_position='N';"           	
                show_menu;
        ;;

	11) clear;

	option_picked "9) Which are   employers who have the highest success rate in petitions more than 70% in petitions and total petions filed more than 1000?"
                hadoop fs -rm -r /Project/question9
	        pig /home/hduser/question9.pig
                echo -e '\nEmployers having success rate more than 70 and petitions more than 1000\n'
                hadoop fs -cat /Project/question9/p*
                show_menu;
        ;;

	12) clear;
		
        option_picked "10) Which are the top 10 job positions which have the  success rate more than 70% in petitions and total petitions filed more than 1000?"

		hadoop fs -rm -r /Project/question10
		pig /home/hduser/question10.pig
                echo -e '\nJob positions having success rate greater than 70 and petitions more than 1000\n'
		hadoop fs -cat /Project/question10/p*
                show_menu;
        ;;

	13) clear;

	option_picked "11) Export result for question no 10 to MySql database."
                mysql -u root -p'root123' -e 'drop table h1b.question11'; 
                mysql -u root -p'root123' -e 'use h1b;create table question11(job_title varchar(100),success_rate float,petitions int);';
                sqoop export --connect jdbc:mysql://localhost:3306/h1b --username root --password 'root123' --table question11 --update-mode allowinsert  --export-dir hdfs://localhost:54310/Project/question10/part-r-00000 --input-fields-terminated-by '\t' ;
                echo -e '\n\nDisplay contents from MySQL Database.\n\n'
                echo -e '\n10) Which are the top 10 job positions that have  success rate more than 70% in petitions and total petitions filed more than 1000?\n\n'
                mysql -u root -p'root123' -e 'select * from h1b.question11 order by success_rate desc';
                show_menu;
        ;;

		\n) exit;   

		;;

        *) clear;

        option_picked "Pick an option from the menu";
        show_menu;
        ;;

    esac

fi

done
