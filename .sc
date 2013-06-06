########################################################
# vim:smd:ar:si:et:bg=dark:ts=4:sw=4
# file: .sc
# author: Chris Olin - http://chrisolin.com
# purpose: portable profile for myself
# created date: 09-18-2012
# last modified: Mon 20 May 2013 04:49:38 PM EDT
# license:
########################################################

### Set environment variables
echo "Setting environment variables"
OS=`uname -s`
HOST=`hostname | sed 's/\..*//'`

### move stale/grab new rc files
echo "Updating configuration files"

# vim   
if [ -f ~/.vimrc_sc ]; then
     mv -f ~/.vimrc_sc ~/.vimrc_sc.old
fi

if [ "$OS" = "Linux" ]; then
    wget -q "http://chrisolin.com/.vimrc_sc" -O ~/.vimrc_sc
    else
        if [ "$OS" = 'CYGWIN_NT-5.1' ] || [ "$OS" = 'Windows_NT' ]; then #updated to work in any (*coughbashandzshsneeze*) posix-compliant shell -- http://tiny.cc/0bq8ww
            wget -q "http://chrisolin.com/.vimrc_cyg" -O ~/.vimrc_sc
            else
                OSUNKNOWN=true
                wget -q "http://chrisolin.com/.vimrc_sc" -O ~/.vimrc_sc
         fi
fi

# screen
if [ -f ~/.screenrc_sc ]; then
    mv -f ~/.screenrc_sc ~/.screenrc.old
fi
if [ "$OS" = "Linux" ]; then
    wget -q "http://chrisolin.com/.screenrc_sc" -O ~/.screenrc_sc
    else
        if [ "$OS" = "CYGWIN_NT-5.1" ]; then
            wget -q "http://chrisolin.com/.screenrc_cyg" -O ~/.screenrc_sc
            else
                OSUNKNOWN=true
                wget -q "http://chrisolin.com/.screenrc_sc" -O ~/.screenrc_sc
         fi
fi

# ssh config

# bash aliases
if [ -f ~/.bash_alias_sc ]; then
    mv -f ~/.bash_alias_sc ~/.bash_alias_sc.old
fi
    
if [ "$OS" = "Linux" ]; then
    wget -q "http://chrisolin.com/.bash_alias_sc" -O ~/.bash_alias_sc
    else
        if [ "$OS" = 'CYGWIN_NT-5.1' ] || [ "$OS" = 'Windows_NT' ]; then #updated to work in any (*coughbashandzshsneeze*) posix-compliant shell -- http://tiny.cc/0bq8ww
            wget -q "http://chrisolin.com/.bash_alias_cyg" -O ~/.bash_alias_sc
            else
                OSUNKNOWN=true
                wget -q "http://chrisolin.com/.bash_alias_sc" -O ~/.bash_alias_sc
         fi
fi

# bashrc
if [ -f ~/.bashrc_sc ]; then
    mv -f ~/.bashrc_sc ~/.bashrc_sc.old
fi
    
if [ "$OS" = "Linux" ]; then
    wget -q "http://chrisolin.com/.bashrc_sc" -O ~/.bashrc_sc
    else
        if [ "$OS" = 'CYGWIN_NT-5.1' ] || [ "$OS" = 'Windows_NT' ]; then #updated to work in any (*coughbashandzshsneeze*) posix-compliant shell -- http://tiny.cc/0bq8ww
            wget -q "http://chrisolin.com/.bashrc_cyg" -O ~/.bashrc_sc
            else
                OSUNKNOWN=true
                wget -q "http://chrisolin.com/.bashrc_sc" -O ~/.bashrc_sc
         fi
fi

# bashrc.sh
if [ -f ~/.bashrc_sc.sh ]; then
    mv -f ~/.bashrc_sc.sh ~/.bashrc_sc.sh.old
fi    
wget -q "http://chrisolin.com/.bashrc_sc.sh" -O ~/.bashrc_sc.sh
chmod +x ~/.bashrc_sc.sh

### setting more variables
echo "tying up some loose ends"
if [ -e "/usr/bin/vim" ]; then 
    EDITOR=/usr/bin/vim
    else
        if [ -e "/usr/bin/vi" ]; then
            EDITOR=/usr/bin/vim
            else
                EDITOR=/usr/bin/nano
        fi
fi

### and this is where the magic starts
echo "Toggling the thingy"
source ~/.bashrc_sc
echo "Success!"

### provide keepalive feature for those pesky SSH timeouts:
echo "Keeping your SSH session alive by regularly echoing a NULL character to the screen..."
(while echo -en "\00" ; do sleep 300 ; done) &
sleep 1

#PROTIP: "sc" stands for "Supercrate". It's a nickname.
