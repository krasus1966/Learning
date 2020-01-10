#!/usr/bin/env python 
# -*- coding:utf-8 -*-
from flask import Flask,render_template,flash

app = Flask(__name__)


app.config["SECRET_KEY"] = "IUHSIUFHSUI"
a = True


@app.route("/")
def index():
    global a
    if a:
        # 添加闪现信息
        flash("hello1")
        flash("hello2")
        flash("hello3")
        a = False

    return render_template("index.html")


if __name__ == '__main__':
    app.run(debug=True)