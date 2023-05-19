data "terraform_remote_state" "core" {
  backend = "local"

  config = {
    path = "../generics/terraform.tfstate"
  }
}