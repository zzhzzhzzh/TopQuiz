{\rtf1\ansi\ansicpg936\cocoartf1671\cocoasubrtf600
{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;\f1\fnil\fcharset0 Menlo-Bold;}
{\colortbl;\red255\green255\blue255;\red204\green108\blue29;\red217\green232\blue247;\red230\green230\blue250;
\red128\green128\blue128;\red154\green140\blue124;\red18\green144\blue195;\red249\green250\blue244;\red30\green181\blue64;
\red121\green171\blue255;\red23\green198\blue163;\red167\green236\blue33;}
{\*\expandedcolortbl;;\csgenericrgb\c80000\c42353\c11373;\csgenericrgb\c85098\c90980\c96863;\csgenericrgb\c90196\c90196\c98039;
\csgenericrgb\c50196\c50196\c50196;\csgenericrgb\c60392\c54902\c48627;\csgenericrgb\c7059\c56471\c76471;\csgenericrgb\c97647\c98039\c95686;\csgenericrgb\c11765\c70980\c25098;
\csgenericrgb\c47451\c67059\c100000;\csgenericrgb\c9020\c77647\c63922;\csgenericrgb\c65490\c92549\c12941;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs24 \cf2 package\cf3  com\cf4 .\cf3 topQuiz\cf4 .\cf3 util\cf4 ;\cf0 \
\
\pard\pardeftab720\partightenfactor0
\cf5 /**\cf0 \
\cf5  * String tool\cf0 \
\cf5  * 
\f1\b \cf6 @author
\f0\b0 \cf5  \ul jady\cf0 \ulnone \
\cf5  *\cf0 \
\cf5  */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf2 public\cf3  \cf2 class\cf3  \cf7 StringUtil\cf3  \cf8 \{\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3 	\cf5 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf5 	 * check whether the string is empty\cf0 \
\cf5 	 * 
\f1\b \cf6 @param
\f0\b0 \cf5  str\cf0 \
\cf5 	 * 
\f1\b \cf6 @return
\f0\b0 \cf0 \
\cf5 	 */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3 	\cf2 public\cf3  \cf2 static\cf3  \cf2 boolean\cf3  \cf9 isEmpty\cf8 (\cf7 String\cf3  \cf10 str\cf8 )\cf3  \cf8 \{\cf0 \
\cf3 		\cf2 if\cf3  \cf8 (\cf10 str\cf3  \cf4 ==\cf3  \cf2 null\cf3  \cf4 ||\cf3  \cf11 ""\cf4 .\cf12 equals\cf8 (\cf10 str\cf4 .\cf12 trim\cf8 ()))\cf3  \cf8 \{\cf0 \
\cf3 			\cf2 return\cf3  \cf2 true\cf4 ;\cf0 \
\cf3 		\cf8 \}\cf0 \
\cf3 		\cf2 return\cf3  \cf2 false\cf4 ;\cf0 \
\cf3 	\cf8 \}\cf0 \
\cf3 	\cf0 \
\cf3 	\cf5 /**\cf0 \
\pard\pardeftab720\partightenfactor0
\cf5 	 * check whether the string is not empty\cf0 \
\cf5 	 * 
\f1\b \cf6 @param
\f0\b0 \cf5  str\cf0 \
\cf5 	 * 
\f1\b \cf6 @return
\f0\b0 \cf0 \
\cf5 	 */\cf0 \
\pard\pardeftab720\partightenfactor0
\cf3 	\cf2 public\cf3  \cf2 static\cf3  \cf2 boolean\cf3  \cf9 isNotEmpty\cf8 (\cf7 String\cf3  \cf10 str\cf8 )\cf3  \cf8 \{\cf0 \
\cf3 		\cf2 if\cf3  \cf8 (\cf10 str\cf3  \cf4 !=\cf3  \cf2 null\cf3  \cf4 &&\cf3  \cf4 !\cf11 ""\cf4 .\cf12 equals\cf8 (\cf10 str\cf4 .\cf12 trim\cf8 ()))\cf3  \cf8 \{\cf0 \
\cf3 			\cf2 return\cf3  \cf2 true\cf4 ;\cf0 \
\cf3 		\cf8 \}\cf0 \
\cf3 		\cf2 return\cf3  \cf2 false\cf4 ;\cf0 \
\cf3 	\cf8 \}\cf3 	\cf0 \
\pard\pardeftab720\partightenfactor0
\cf8 \}\cf0 \
}