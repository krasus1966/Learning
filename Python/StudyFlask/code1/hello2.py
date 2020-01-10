from flask import Flask, redirect, url_for
from werkzeug.routing import BaseConverter
app = Flask(__name__)


@app.route("/")
def hello_world():
    return 'Hello World!'


# 通过methods限定访问方式
@app.route("/post_only", methods=["POST"])
def post_only():
    return "post only page"

# 使用url_for的函数通过视图函数的名字找到试图对应的url路径
# 跳转
@app.route("/login")
def login():
    url = url_for("hello_world")
    return redirect(url)

# 转换器
# 127.0.0.1:5000/goods/123

@app.route("/goods/<int:goods_id>") #不加转换器类型，默认是普通的字符串规则（除了斜线以外的字符）
def goods_detail(goods_id):
    return "goods detail page %s" % goods_id 

# 1.定义自己的转换器
class RegexConverter(BaseConverter):
    def __init__(self,url_map,regex):
        # 调用父类的初始化方法
        #super(RegexConverter,self).__init__(url_map) #python2.x必须写
        super()
        # 将正则表达式使用的参数保存到对象的属性中，flask会去使用这个属性来进行路由的正则匹配
        self.regex = regex

class MobileNum(BaseConverter):
    def __init__(self,url_map):
        super()
        self.regex = r'1[34578]\d{9}'

# 2.将自定义的转换器添加到flask的应用中
app.url_map.converters["re"] = RegexConverter
app.url_map.converters["mobile"] = MobileNum
# 不加转换器类型，默认是普通的字符串规则（除了斜线以外的字符）
@app.route("/send/<re(r'1[34578]\d{9}'):mobile>")
def send_sms(mobile):
    return "send sms to %s" % mobile

@app.route("/send2/<mobile:mobile_num>")
def send_sms1(mobile_num):
    return "send sms to %s" % mobile_num

if __name__ == '__main__':
    print(app.url_map)  # 通过url_map可以查看整个flask中的路由信息
    app.run(debug=True)
