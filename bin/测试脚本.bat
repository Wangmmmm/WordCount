wc.exe
wc.exe -c
wc.exe -c input.c
wc.exe -c -w input1.c -o out1.txt
wc.exe -c -w -l input2.c -o out2.txt
wc.exe -c -w -l -a input3.c -o out3.txt
wc.exe -a -l -c -w input3.c -o out4.txt
wc.exe -s -c -w -l -a *.c -o out5.txt
wc.exe -c -w -l -a  input3.c -e stoplist.txt -o out6.txt
wc.exe -s -c  -w -l -a  *.c -e stoplist.txt -o out7.txt
pause