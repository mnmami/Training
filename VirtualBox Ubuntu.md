# Install VirtualBox on Linux
```
wget <dep file>
sudo dpkg -i <dep file>
```
Get deb file from: https://www.virtualbox.org/wiki/Linux_Downloads

# Install VirtualBox on Linux (Debian)
- Edit `/etc/apt/sources.list` and add following line to the end (replace <mydist> with your distribution - see below):
```
deb https://download.virtualbox.org/virtualbox/debian <mydist> contrib
``` 
 mydist can be one of those: 'artful', 'zesty', 'yakkety', 'xenial', 'vivid', 'utopic', 'trusty', 'raring', 'quantal', 'precise', 'stretch', 'lucid', 'jessie', 'wheezy', or 'squeeze'

- Run
```
wget -q https://www.virtualbox.org/download/oracle_vbox_2016.asc -O- | sudo apt-key add -
wget -q https://www.virtualbox.org/download/oracle_vbox.asc -O- | sudo apt-key add -
```
- Then
```
sudo apt-get update
sudo apt-get install virtualbox-5.2
```
