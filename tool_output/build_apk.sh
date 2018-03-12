#!/usr/bin/env bash

java -jar AndResGuard-cli-1.2.12-DEBUG.jar ../app/build/outputs/apk/*/*/*.apk -config config.xml -out outapk -signatureType v2 -signature
