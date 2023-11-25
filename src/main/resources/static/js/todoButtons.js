{

    //테이블 id값을 저장할 전역변수
    // var id="";
    var clickedRowValues = [];


    <!-- 생성 -->
    {
        //  생성 버튼 변수화
        const todoCreateBtn = document.querySelector("#new-todo-btn");
        // 클릭 이벤트 감지!
        todoCreateBtn.addEventListener("click", function() {
            // 새 객체 생성
            const toDoJson = {
                schedule_id: document.querySelector("#edit-todo-schedule-id").value,
                todo: document.querySelector("#new-todo").value,
                created : document.querySelector("#new-todo-create-date").value,
                due_date: document.querySelector("#new-todo-due-date").value,
                priority: document.querySelector("#new-priority-check").checked

            };
            // 객체 출력
            console.log(toDoJson);
            // fetch() - 비동기 통신을 위한 API
            const url = "/home/addTodo";
            fetch(url, {
                method: "post",
                body: JSON.stringify(toDoJson),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => {
                // http 응답 코드에 따른 메시지 출력
                const msg = (response.ok) ? "생성 완료" : "생성 실패..!";
                alert(msg);
                window.location.reload();
            });
        });
    }

    // 테이블의 Row 클릭시 값 가져오기
    {
        table.addEventListener("click", function (event) {
            // 클릭된 엘리먼트가 테이블 셀(td)인지 확인
            if (event.target.tagName === "TD") {
                // 클릭된 행(tr) 가져오기
                var clickedRow = event.target.parentNode;

                // 클릭된 행의 셀(td) 가져오기
                var cells = clickedRow.getElementsByTagName("td");

                // 이전 값 초기화
                clickedRowValues = [];

                // 셀을 순회하며 값을 전역 변수에 저장
                for (var i = 0; i < cells.length; i++) {
                    var cellValue = cells[i].innerText;
                    clickedRowValues.push(cellValue);
                }

                // 전역 변수 콘솔에 출력 (테스트용)
                console.log("클릭된 행의 값: ", clickedRowValues);
            }
        });
    }
    // $("#table tr").click(function(){
    //
    //   // 현재 클릭된 Row(<tr>)
    //   var tr = $(this);
    //   var td = tr.children();
    //
    //   // tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
    //   console.log("클릭한 Row의 모든 데이터 : "+tr.text());
    //
    //   // td.eq(index)를 통해 값을 가져올 수도 있다.
    //   id = td.eq(3).text();
    //   console.log(id);
    //
    // });
    <!-- 수정 -->
    {
        // 모달 요소 선택
        const todoEditModal = document.querySelector("#todo-edit");//
        const todoEditBtn = document.querySelector("#edit-todo-btn");

        // 모달 이벤트 감지
        todoEditModal.addEventListener("click", function () {
            console.log("클릭되었습니다")

            // 데이터 가져오기
            //const checkbox = document.getElementById("#table").getElementsByTagName("tr")[id].getElementsByTagName("th")[0]
            const todo = clickedRowValues[0];
            const createDate = clickedRowValues[1];
            const dueDate = clickedRowValues[2];
            const todoId = clickedRowValues[3];
            console.log(`${todo}, ${createDate}, ${dueDate}, ${todoId}`);
            // 데이터를 반영
            //document.querySelector("#edit-priority-check").value = checkbox;
            document.querySelector("#edit-todo").value = todo;
            document.querySelector("#edit-todo-due-date").value = dueDate;
            document.querySelector("#edit-todo-id").value = todoId;

            todoEditBtn.addEventListener("click", editButtonClick);

        });
    }

    function editButtonClick(){
        const toDoJson = {
            id : document.querySelector("#edit-todo-id").value,
            todo: document.querySelector("#edit-todo").value,
            create_date: document.querySelector("#edit-todo-due-date").value,
            due_date: document.querySelector("#edit-todo-due-date").value,
            priority: document.querySelector("#edit-priority-check").checked

        };
        // 객체 출력
        console.log(toDoJson);
        // fetch() - 비동기 통신을 위한 API
        const url = "/home/editTodo/"+toDoJson.id;
        fetch(url, {
            method: "put",
            body: JSON.stringify(toDoJson),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(response => {
            // http 응답 코드에 따른 메시지 출력
            const msg = (response.ok) ? "수정 완료" : "수정 실패..!";
            alert(msg);
            window.location.reload();
        });
    }

    <!-- 삭제 -->
    {

        // 삭제 버튼 선택
        const todoDeleteBtns = document.querySelector("#todo-delete");

        // 각 버튼의 이벤트 처리를 등록
        todoDeleteBtns.addEventListener("click", () => {
            console.log("삭제 버튼 클릭 ="+clickedRowValues);
            console.log("삭제 버튼 클릭 id ="+clickedRowValues[3]);
            // 삭제 API 호출 및 처리
            const url = "/home/delete/"+clickedRowValues[3];
            fetch(url, {
                method: "DELETE"
            }).then(response => {
                // 댓글 삭제 실패 처리
                if (!response.ok) {
                    alert("할일 삭제 실패..!");
                }else
                    alert("할일 삭제 성공");
                window.location.reload();
            });
        });
    }
}