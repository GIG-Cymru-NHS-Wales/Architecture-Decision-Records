##
# all: do all the typical steps.
##
.PHONY: all
all: install sync run ;

##
# help: display this help message.
##
.PHONY: help
help:
	@awk '/^##/{a=1-a}a' $(MAKEFILE_LIST) | cut -c3-

##
# install: install any project aspects; this will install the command `uv`.
##
.PHONY: install
install: 
	curl -LsSf https://astral.sh/uv/install.sh | sh
	@echo "The uv command should now be installed and available."

##
# sync: synchronize the project aspects; this will run the command `uv sync`.
##
.PHONY: sync
sync: 
	uv sync
	@echo "The uv command should now be synchronized and configured."

##
# run: run the project aspects; this will launch the documentation server.
##
.PHONY: run
run: 
	uv run mkdocs serve
	@echo "The documentation should now be available by browsing http://127.0.0.1:8000/"

##
# deploy: build and deploy the latest docs to GitHub pages (gh_pages branch push)
##
.PHONY: deploy
deploy:
	uv run mkdocs gh-deploy --force
	@echo "The documentation should now be available by browsing https://gig-cymru-nhs-wales.github.io/Architecture-Decision-Records/"

##
# newline: display a newline character so we can print prettier messages.
##
.PHONY: newline
define newline


endef
