<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/afe84ff5fe.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./resources/css/styles.css">
        <title>Login</title>
    </head>

    <body>
        <div class="container vh-100 d-flex justify-content-center align-items-center">
            <div class="formulario w-50">
                <input type="hidden" id="status" value="${request.getAttribute('status')}">
                <h2 class="text-center mb-5">Nuevo Usuario</h2>
                <form action="registrarse" method="post" class="row g-3">

                    <div class="mb-3">
                        <input type="text" id="nombre" name="nombre" required class="form-control" placeholder="Nombre"
                            aria-label="Nombre">
                    </div>
                    <div class="mb-3">
                        <input type="text" id="apellido" name="apellido" required class="form-control"
                            placeholder="Apellido" aria-label="Apellido">
                    </div>

                    <div class="mb-3">
                        <label for="correo" class="form-label">Email</label>
                        <input type="email" id="correo" name="correo" placeholder="ejemplo@email.com" required
                            class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="clave" class="form-label">Contraseña</label>
                        <input type="password" id="clave" name="clave" placeholder="*****" minlength="4" required
                            class="form-control">
                    </div>
                    <div class="d-grid">
                        <input type="submit" value="Registrar" class="btn btn-primary">
                    </div>
                </form>
                <p class="text-center mt-3">Si ya tienes cuenta<a href="login">click aquí!</a></p>
            </div>
        </div>

        <footer>
            <div id="footer">
              <p>&copy; 2024 Alkewallet Bank</p>
              <div class="icon-footer">
                <a href="#" target="_blank"><i class="fab fa-facebook"></i></a>
                <a href="#" target="_blank"><i class="fab fa-twitter"></i></a>
                <a href="#" target="_blank"><i class="fab fa-instagram"></i></a>
            </div>
            </div>
          </footer>
    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    </body>

    </html>