How to use:

To create a oneline sshkey (private for bootstrap.yml):
* awk 'NF {sub(/\r/, ""); printf "%s\\n",$0;}' sshkey > onelinesshkey
* Edit properties/bootstrap.yml: privateKey

To Run:
java -Dspring.profiles.active=dev -Dspring.config.additional-location=file:./properties -jar build/libs/configserver-0.0.1-SNAPSHOT.jar
