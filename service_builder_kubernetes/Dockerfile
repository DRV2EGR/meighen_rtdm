# first stage

# FROM hseeberger/scala-sbt:11.0.6_1.3.9_2.13.1 as build
# WORKDIR /src
# COPY . /src/
# RUN sbt clean compile 
# RUN sbt dist 
# RUN sbt universal:packageZipTarball
# #RUN sbt -verbose -debug -Dsbt.override.build.repos=true clean compile dist universal:packageZipTarball
# WORKDIR /src/target/universal
# RUN tar xvzf *.tgz

# FROM openjdk:8
# RUN mkdir /app
# COPY --from=build /src/target/universal/service_builder_kubernetes/ /app/
# EXPOSE 9000
# WORKDIR /app
# CMD ["sleep","3600"]
# CMD ["nohup", "/app/bin/service_builder_kubernetes"]


FROM hseeberger/scala-sbt:11.0.6_1.3.9_2.13.1 AS build2

WORKDIR /appa
COPY ./ ./

RUN sbt clean
RUN sbt assembly

EXPOSE 9092

CMD ["java", "-cp", "target/scala-3.2.2/service_builder_kubernetes-assembly-0.1.0-SNAPSHOT.jar", "consumer.ConsumerPlayground"]




# second stage

# FROM openjdk:8-jre-alpine3.9 

# COPY --from=build /app/*.jar /service_builder_kubernetes.jar
# COPY --from=build /root/.ivy2/cache/org.scala-lang/scala-library/jars/scala-library-2.12.2.jar /scala-library-2.12.2.jar

# CMD ["scala", "service_builder_kubernetes.jar", "consumer.ConsumerPlayground"]

# FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1

# # RUN  apt-get update \
# #   && apt-get install -y \
# #     apt-transport-https \
# #   && apt-get clean \
# #   && rm -rf /var/lib/apt/lists/* /var/tmp/*

# # RUN apt-get update
# # RUN apt-get install bc

# # RUN echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list \
# #     && apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823

# # ENV SBT_VERSION 1.0.3

# # RUN apt-get update \
# #   && apt-get install -y sbt=$SBT_VERSION \
# #   && apt-get clean \    
# #   && rm -rf /var/lib/apt/lists/* /var/tmp/*

# RUN mkdir -p /root/build/project
# ADD build.sbt /root/build/
# # ADD ./project/plugins.sbt /root/build/project
# RUN cd /root/build 
# # RUN sbt package
# # RUN sbt compile

# EXPOSE 9000
# WORKDIR /root/build

# CMD sbt compile run
