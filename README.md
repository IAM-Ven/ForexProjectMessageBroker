# ForexProjectMessageBroker
#### External service for ForeignExchangePlatform connected via RabbitMQ Message Broker

[![Build Status](https://travis-ci.com/mlipski00/ForexProjectMessageBroker.svg?branch=master)](https://travis-ci.com/mlipski00/ForexProjectMessageBroker)

Internal subservices:
* Sending quotations from Forex Platform via simple message broker queue
* Sending quotations via remote procedure call (RPC)

Data is save to embedded mongoDB.
