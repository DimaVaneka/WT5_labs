<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Administration</title>
        <jsp:include page="/jsp/blocks/siteresourceslinks.jsp"/>

        <link rel="stylesheet" href="../resources/css/bootstrap-table.css">
        <script src="../resources/js/bootstrap-table.js"></script>
        <script src="../resources/js/lodash.min.js"></script>
        <script src="../resources/js/bootstrap-table-filter-control.min.js"></script>
        <script src="../resources/js/custom/adminpage/adminPageActions.js"></script>
    </head>
    <body>

        <jsp:include page="/jsp/blocks/sitenavbar.jsp"/>

        <jsp:include page="/jsp/blocks/jumbotronblock.jsp">
            <jsp:param name="pageTitle" value="Administration page"/>
            <jsp:param name="titleDescription" value="Actual information about all students."/>
        </jsp:include>

        <div class="container">
            <div class="btn-toolbar">
                <div class="btn-group ">
                    <a href="/registration/faculty" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Create faculty / speciality</a>
                    <a href="/registration" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span> Register student / head of practice</a>
                </div>

                <div class="btn-group ">
                    <button type="submit" id="assign_students_btn" disabled="disabled" class="btn btn-success" data-toggle="modal" data-target="#assign_modal">Assign student(s)</button>
                    <button type="button" id="release_students_btn" disabled="disabled" class="btn btn-primary">Release student(s)</button>
                </div>

                <div class="btn-group ">
                    <a href="/practicesRequests" class="btn btn-primary">Show all requests</a>
                </div>

                <div class="btn-group ">
                    <button type="button" id="delete_students_btn" disabled="disabled" class="btn btn-danger">Delete student(s) <span class="glyphicon glyphicon-trash"></span></button>
                </div>

            </div>
        </div>


        <br/>
        <div class="container">
            <table class="table table-no-bordered" id="table1" data-toggle="table"
                   data-classes="table table-no-bordered"
                   data-click-to-select="true"
                   data-url="/studentsAndPracticeData"
                   data-id-field="id"
                   data-side-pagination="server"
                   data-pagination="true"
                   data-page-size="5"
                   data-page-list="[5, 10, 20]"
                   data-search="true"
                   data-response-handler="responseHandler"
                   data-show-columns="true"
                   data-show-refresh="true"
                   data-show-toggle="true"
                   data-filter-control="true"
                   data-filter-show-clear="true"
                   >
                <thead>
                <tr>
                    <th data-field="state" data-checkbox="true" data-align="center"></th>
                    <th data-field="surname" data-sortable="true" data-align="center">Surname</th>
                    <th data-field="name"  data-align="center">Name</th>
                    <th data-field="faculty" data-align="center">Faculty</th>
                    <th data-field="speciality" data-align="center">Speciality</th>
                    <th data-field="budget" data-filter-control="select" data-align="center">Education basis</th>
                    <th data-field="avrMark" data-sortable="true" data-align="center">Average mark</th>
                    <th data-field="status" data-filter-control="select" data-align="center">Status</th>
                    <th data-field="company" data-align="center">Company</th>
                    <th data-field="practicePeriod" data-align="center">Practice period</th>
                    <th data-field="id" data-formatter="LinkFormatter" data-align="center">Show profile</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>

        <script>
            function LinkFormatter(value, row, index) {
                return "<a href=\"studentProfile/"+value+"\" class=\"btn btn-default btn-block\">Profile <span class=\"glyphicon glyphicon-user\"></span></a>";
            }
        </script>

        <br/>

        <div class="modal fade" id="assign_modal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">x</button>
                        <h4 class="modal-title">Assign student(s)</h4>
                    </div>
                    <div class="modal-body">
                        <h2 class="text-center">Assign information:</h2>

                        <div class="table-responsive">
                            <table class="table table-no-bordered"
                                   id="assign_student_table"
                                   data-toggle="table"
                                   data-classes="table table-no-bordered"
                                   data-click-to-select="true">
                                <thead>
                                    <tr>
                                        <th data-field="name">Student name</th>
                                        <th data-field="faculty">Faculty</th>
                                        <th data-field="speciality">Speciality</th>
                                        <th data-field="avrMark">Average mark</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                        <br/>
                        <form>
                            <div class="form-group">
                                <label class="control-label ">Choose practice request:</label>
                                <div class="">
                                    <select id="practices_requests_select" class="form-control">

                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="button" id="assign_student_form_btn" class="btn btn-success btn-block">Assign student(s)</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!--Alert Modal -->
        <div class="modal fade" id="alert_modal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">x</button>
                    </div>
                    <div class="modal-body">
                        <div class="alert alert-success">
                            <strong>Success!</strong> <span id="alert_text"></span>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success btn-block" data-dismiss="modal" id="alert_close_btn">Ok</button>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="/jsp/blocks/sitefooter.jsp"/>
    </body>
</html>
