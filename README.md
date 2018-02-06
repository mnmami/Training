# Training
## STEP 1: Make the base setup
- Download and install VirtualBox (pick the one that corresponds to your system & prefer version the latest version 5.2.x): https://www.virtualbox.org/wiki/Downloads
  - For Ubuntu (Debian) users see: https://github.com/mnmami/Training/blob/master/VirtualBox_Ubuntu.md
- Download and install Vagrant (pick the one that corresponds to your system & prefer the latest version 2.0.x): https://www.vagrantup.com/downloads.html 
  - For Linux (Debian) users see: https://github.com/mnmami/Training/blob/master/Vagrant_Ubuntu.md

## STEP 2: Get and configur the environment
- Open a terminal and create a folder for your Vagrant project then navigate to it:
```
mkdir myvagrant
cd myvagrant
```
- Create a file called  `Vagrantfile` and put inside it:
```
Vagrant.configure("2") do |config|
  config.vm.provision "shell", inline: "echo Hello there"
  # config.ssh.insert_key = false

  config.vm.define "master" do |master|
    master.vm.box = "ubuntu/xenial64"
    master.vm.network "public_network", ip: "192.168.0.10"
    master.vm.network "forwarded_port", guest: 4040, host: 4040
    master.vm.network "forwarded_port", guest: 8080, host: 8080
    master.vm.hostname = "ubuntu1"
  end

  config.vm.define "slave" do |slave|
    slave.vm.box = "ubuntu/xenial64"
    slave.vm.network "public_network", ip: "192.168.0.11"
    slave.vm.network "forwarded_port", guest: 8081, host: 8081
    slave.vm.hostname = "ubuntu2"
  end
```
- Windows users
  - add in the third line `config.ssh.insert_key = false`
  - do not use `sudo` in all the command lines
- Then run: `sudo vagrant up` and wait a few minutes 

## STEP 3: Connect (SSH) to the Master and Slave boxes
Once STEP 2 is done successfully, we obtain two Linux 16.04 boxes (guest virtual machines) connected between them using a (public) network. One will be used as Apache Spark Master, the other for the slave. We also exposed the ports 4040, 8080 and 8181 to the host machine (that runs Vagrant). We use those ports to open web interfaces to the master and slave.
- Now, ssh to the master using `sudo vagrant ssh master` and open another terminal and ssh to the slave using `sudo vagrant ssh slave`. *Now you are moving to an Ubuntu System*.
- In both boxes run to install the missing packages: `sudo apt-get update`

## STEP 4: Install Java (in both boxes)
- Run the dollowing 2 lines:
```
sudo apt-get install openjdk-8-jre
sudo apt-get update
```
