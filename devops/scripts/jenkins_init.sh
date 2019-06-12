#!/bin/bash

echo Initializing Jenkins Server...

# Updating system
echo Updating existing system packages...
{
    apt-get -y update
    apt-get -y upgrade
} &>> ~/init.log

# Install Newman for API testing
echo Installing Newman API endpoint testing suite...
{
    apt-get -y install nodejs
    apt-get -y install npm
    npm install -g newman
} &>> ~/init.log