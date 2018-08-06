FROM mysql:5.6

LABEL maintainer="steliomo@gmail.com"

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=msaude
ENV MYSQL_USER=msaude
ENV MYSQL_PASSWORD=msaude
ENV MYSQL_DATA_DIRECTORY=/opt/data/system/mysql

ADD mysql.cnf /root/.my.cnf
ADD localtime /etc/localtime

COPY run.sh /run.sh

VOLUME /opt/msaude/data

EXPOSE 3306

CMD ["/run.sh"]