# Training
## STEP 1: base setup
- Download and install VirtualBox (pick the one that corresponds to your system & prefer version the latest version 5.2.x): https://www.virtualbox.org/wiki/Downloads
  - For Ubuntu (Debian) users see: https://github.com/mnmami/Training/blob/master/VirtualBox_Ubuntu.md
- Download and install Vagrant (pick the one that corresponds to your system & prefer the latest version 2.0.x): https://www.vagrantup.com/downloads.html 
  - For Linux (Debian) users see: https://github.com/mnmami/Training/blob/master/Vagrant_Ubuntu.md

## STEP 2: Get and configur the environment
- Create a folder for your Vagrant project: `mkdir myvagrant` then navigate to it `cd myvagrant`
- Create a file called  `Vagrantfile` and put inside it:
```
Vagrant.configure("2") do |config|
  config.vm.provision "shell", inline: "echo Hello there"
  config.ssh.insert_key = false

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
- Windows users add to the second line `config.ssh.insert_key = false`
- Then run: `vagrant up` and wait a few minutes. 
The Vagrantfile instructs to install two Linux 16.04 boxes and create a (public) network between them 
