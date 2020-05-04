# configure.sh
# Configuration script for Jenkins Pipelines course

# Install Vim
sudo apt install vim -y

# Install Git
sudo apt install git -y

# Install JDK
sudo apt install openjdk-8-jdk -y

# Install Maven
sudo apt install maven -y

# Install Jenkins
wget -q -O - https://pkg.jenkins.io/debian/jenkins.io.key | sudo apt-key add –
sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 9B7D32F2D50582E6
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
sudo add-apt-repository universe
sudo apt-get update
sudo apt-get install jenkins -y

# Jenkins agents require two new directories
sudo mkdir /var/lib/jenkinsAlpha
sudo chown jenkins:jenkins /var/lib/jenkinsAlpha
sudo mkdir /var/lib/jenkinsBravo
sudo chown jenkins:jenkins /var/lib/jenkinsBravo
