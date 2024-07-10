# PoC: Decompose on multi-module project (single graph)


This repository contains a proof of concept for navigation in multi-module applications using Decompose. In this app, we have:

- composeApp (root)
- featureA
- featureB

The idea is that `RootNavigation` is responsible for the navigation graph, while the Screens and Configurations are provided by another module (`Navigation`) with no interdependencies.

Navigation becomes simple since all `Screens` and `Configurations` will be available to all modules. Any module can access the Navigator through LocalComposition and push to the stack in any Configuration, regardless of whether it is in another module.
