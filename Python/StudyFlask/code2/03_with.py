#!/usr/bin/env python 
# -*- coding:utf-8 -*-

# 上下文管理器
# with open("./1.txt","wb") as f:
#     f.write("Hello flask")

class Foo(object):
    def __enter__(self):
        """进入with语句的时候被调用"""
        print ("enter called")

    def __exit__(self,exc_type,exc_val,exc_tb):
        """离开with语句的时候被with调用"""
        print("exc_type: %s" % exc_type)
        print("exc_val: %s" % exc_val)
        print("exc_tb: %s" % exc_tb)

with Foo()as foo:
    print("hello python")