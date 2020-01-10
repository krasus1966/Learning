#!/usr/bin/env python 
# -*- coding:utf-8 -*-
from flask import Flask, render_template

app = Flask(__name__)


@app.route("/index")
def index():
    data = {
        "list": [1, 2, 3, 4, 5]
    }
    return render_template("index.html", **data)

@app.template_filter("li2")
def list_step_2(li):
    """自定义过滤器"""
    return li[::2] 

if __name__ == '__main__':
    app.run(debug=True)
