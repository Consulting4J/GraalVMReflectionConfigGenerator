# GraalVMReflectionConfigGenerator  
To help to generate the most complex part reflect-config.json which graalvm native image build needed  
if you use native-image-agent to track your application to generate the models your app need, you may have to build a very complex script  
with this helper you just put all the model class name in a list and save as an file, then something like the following would be generated automatically.  


{  
  "name":"com.yourcompany.Milestone",   
  "allDeclaredFields":true,  
  "allPublicMethods":true,  
"fields":[  
{"name":"date"},   
{"name":"projectID"},   
{"name":"description"},   
{"name":"trafficLight"},   
{"name":"creatorID"},   
{"name":"createDate"},   
{"name":"creatorName"},   
{"name":"index"}   
],  
  "methods":[{"name":"<init>","parameterTypes":[] }]  
},    
  
 
