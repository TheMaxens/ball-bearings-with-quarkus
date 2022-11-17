FROM ubuntu:focal
# receive build-arguments 
ARG GH_TOKEN 
ARG username
ARG email
# set GH_TOKEN as env variable 
ENV GH_TOKEN=${GH_TOKEN}
# install git
RUN apt update -y && apt install git -y
# install gpg
RUN apt update -y && apt install gpg -y
# install GitHub CLI (gh)
RUN type -p curl >/dev/null || apt install curl -y
RUN curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg \
    && chmod go+r /usr/share/keyrings/githubcli-archive-keyring.gpg \
    && echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] https://cli.github.com/packages stable main" | tee /etc/apt/sources.list.d/github-cli.list > /dev/null \
    && apt update \
    && apt install gh -y
# clone repo 
RUN gh repo clone themaxens/ball-bearings-with-quarkus
# configure git to use GitHub CLI as a credential helper
RUN gh auth setup-git
# setup git
WORKDIR /ball-bearings-with-quarkus
RUN git config gpg.program gpg
# RUN git config commit.gpgsign true
RUN git config user.name "${username}"
RUN git config user.email "${email}"
# install curl 
RUN apt-get install -y curl
RUN curl -Ls https://sh.jbang.dev | bash -s - trust add https://repo1.maven.org/maven2/io/quarkus/quarkus-cli/ 
RUN curl -Ls https://sh.jbang.dev | bash -s - app install --fresh --force quarkus@quarkusio
CMD ["bash"]