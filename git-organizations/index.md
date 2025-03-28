# Git organizations

**Status**: first sketch, work in progress, request for collaboration

**Date**: 2025-03-27

**Governance**: To Be Discovered; potentially a combo of this repo partipants, DHCW CISO, NHS Wales UCB peers, etc.


## Situation - Context and Problem Statement

Generally we aim to encourage principles of public health, public health code, public health data, public health participation, and public health involvement.

Specifically Joel needs to immediately work on the emergency department module authentication demonstration, which involves external Microsoft Entra free accounts, all fake data for testing purposes, and open for partners and advisors especially Microsoft, Kainos, Capacitas, NCSC. The immediate next project is radiology test automation with rapid setup of fake data such as via external FHIR services.

Joel is delivering these via a public health free open source git organization. This is a new capability for NHS Wales and for DHCW, based on best practices for U.S. healthcare companies that have a bright-line divider between their external-public-free-open-source and their internal-private-expensed-closed-source.

Dan wants to use the learnings that come from these, in order to improve the internal systems.


## Background - Decision Drivers

Joel's decision drivers are the typical best practices in the U.S. and E.U. which is to create a bright-line information security separation between two categories of work: 

1. Category one is for the public. This includes things like demonstrations, examples, tutorials, free open source software, fake testing information, data that is free and clear of any personally identifying information, etc.

2. Category two is for employees. This includes things like internal-only applications, employment records, paid closed source software, personally identifiable information (PII), confidential documents, security secrets, and the like.

This is the approach taken by organizations such as Apple, Microsoft, Google, etc. and it improves security with U.S. SOC 2 compliance, the EU Cybersecurity Act, the  International Standards Organization (ISO) 27001 information security framework, etc.

Dan's decision drivers are TODO @Dan.


### Decision Driver Questions

One of the areas we're exploring as a group on our chat is coming up with questions that can help us assess options.

Here are  some questions that we're considering thus far.

TODO @Joel add questions here.

TODO @Dan add questions here.


## Assessment - Considered Options

Option 1: Our current path. 

  * Joel and DevOps continue to use the category one GitHub repo. 
  
  * Dan and NDR continue to use the category 2 GitHub repo, plus do anything they want to improve the internal systems. 
  
  * We update each other about learnings as we go. 

  * We revisit together later on, such as after the emergency department module ships and the radiology testing ships.

Option 2: TODO @Dan.


## Recommendation - Decision Outcome


