from flask import Flask
app = Flask(__name__)

@app.route('/goods/<>')
def hello_world():
    return 'Hello World!'

if __name__=='__main__':
    app.run()
    #app.run(host="192.168.1.1",port="5000",debug=True)