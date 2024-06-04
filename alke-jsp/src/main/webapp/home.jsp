<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css" href="./resources/css/styles.css">
    <script src="https://kit.fontawesome.com/afe84ff5fe.js" crossorigin="anonymous"></script>
    <title>AlkeWallet-Home</title>
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg bg-dark bg-body-tertiary mb-3">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">AlkeWallet Bank</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="home">Depositar/Retirar</a>
                    </li>
                    
                </ul>
            </div>
        </div>
    </nav>
    <main>
        <div class="container mt-3">
            <% User usuario=(User) session.getAttribute("usuario"); String status=(String)
                session.getAttribute("status"); %>
            <input type="hidden" id="status" value="<%= status %>">
            <h2 class="text-center">Bienvenido, <%= usuario !=null ? usuario.getNombre() + " " + usuario.getApellido() : "" %></h2>
            <div class="d-flex justify-content-center mt-3">
                <div class="card mb-3" style="max-width: 18rem;">
                    <div class="card-body">
                        <form action="operacion" method="post">
                            <div class="form-group">
                                <label for="monto">
                                    <h5>Ingrese cantidad:</h5>
                                </label>
                                <input type="number" id="monto" name="monto" class="form-control" />
                                <h5 class="mt-2">Saldo:</h5>
                                <p class="text-danger fs-5">$<%= usuario !=null ? usuario.getSaldo() : "" %></p>
                            </div>
                            <div id="liveAlertPlaceholder">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">
                                        <button type="submit" id="operacionDepositar" name="operacionDepositar"
                                            class="btn btn-secondary w-100">
                                            Depositar
                                        </button>
                                    </li>
                                    <li class="list-group-item">
                                        <button type="submit" id="operacionRetirar" name="operacionRetirar"
                                            class="btn btn-secondary w-100">
                                            Retirar
                                        </button>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="logout" id="logout" class="btn bg-gradient bg-success text-light w-100">
                                            Cerrar sesión
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <footer class="text-center mt-4">
        <p>&copy; 2024 Alkewallet Bank</p>
        <div class="icon-footer">
            <a href="#" target="_blank"><i class="fab fa-facebook"></i></a>
            <a href="#" target="_blank"><i class="fab fa-twitter"></i></a>
            <a href="#" target="_blank"><i class="fab fa-instagram"></i></a>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>
