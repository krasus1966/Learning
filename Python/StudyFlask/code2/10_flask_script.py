#!/usr/bin/env python 
# -*- coding:utf-8 -*-
from flask import Flask, session
from flask_script import Manager #启动命令的管理类
app = Flask(__name__)

# 创建Manager管理类的对象
manager = Manager(app)

@app.route("/index")
def index():
    # 获取session 数据
    name = session.get("name")
    return "hello %s" % name


if __name__ == '__main__':
    # app.run(debug=True)
    # 通过管理对象来启动flask
    manager.run

