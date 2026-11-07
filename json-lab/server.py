from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route("/api/analyze", methods=["POST"])
def analyze():
    data = request.get_json()
    try:
        # Expects NUMBERS in itemPrices
        total = sum(data["itemPrices"])
        return jsonify(customer=data["customerName"], total=total)
    except Exception as e:
        return jsonify(error=type(e).__name__, detail=str(e)), 400

if __name__ == "__main__":
    app.run(port=8080)