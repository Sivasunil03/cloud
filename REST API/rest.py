from flask import Flask, request, jsonify
app = Flask(__name__)

# sample data
students = [
    {"id": 1, "name": "Sunil", "course": "MCA"},
    {"id": 2, "name": "Charan", "course": "CSE"}
]

# GET all students OR create new
@app.route('/students', methods=['GET', 'POST'])
def students_list():
    if request.method == 'GET':
        return jsonify(students)
    data = request.get_json()
    new = {"id": len(students)+1, "name": data["name"], "course": data["course"]}
    students.append(new)
    return jsonify(new), 201

# GET, UPDATE, DELETE single student
@app.route('/students/<int:student_id>', methods=['GET', 'PUT', 'DELETE'])
def student_detail(student_id):
    student = next((s for s in students if s["id"] == student_id), None)
    if not student:
        return jsonify({"error": "Not found"}), 404
    if request.method == 'GET':
        return jsonify(student)
    if request.method == 'PUT':
        data = request.get_json()
        student["name"] = data.get("name", student["name"])
        student["course"] = data.get("course", student["course"])
        return jsonify(student)
    students.remove(student)
    return jsonify({"message": "Deleted"}), 200

if __name__ == '__main__':
    app.run(host="0.0.0.0", port=5000)
