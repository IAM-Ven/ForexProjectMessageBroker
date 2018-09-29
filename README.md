# ForexProjectMessageBroker
#### External service for ForeignExchangePlatform connected via RabbitMQ Message Broker

[![Build Status](https://travis-ci.com/mlipski00/ForexProjectMessageBroker.svg?branch=master)](https://travis-ci.com/mlipski00/ForexProjectMessageBroker)


[![codecov](https://codecov.io/gh/mlipski00/ForexProjectMessageBroker/branch/master/graph/badge.svg)](https://codecov.io/gh/mlipski00/ForexProjectMessageBroker)

Internal subservices:
* Receiving quotations from Forex Platform via simple message broker queue
* Receiving quotations via remote procedure call (RPC)

Data is save to embedded mongoDB.
