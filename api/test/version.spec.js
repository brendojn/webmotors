import chai from 'chai'
import chaiHttp from 'chai-http'
import * as constant from '../env'

chai.use(chaiHttp)

const request = chai.request(constant.URL_API)

const expect = chai.expect

describe("Validar modelos de veículos", () => {

    it('devo validar todos os modelos para a marca chevrolet ', (done) => {
        request
            .get("/Version?ModelID=1")
            .end((err, res) => {
                expect(res).to.has.status(200);
                for (let i = 0; i < res.body.length; i++) {
                    expect(res.body[i].ModelID).to.equal(1);
                }
                done()
            })
    })
})

describe("Não passar valor do modelo", () => {

    it('devo receber uma mensagem de request inválida ', (done) => {
        request
            .get("/Version?ModelID=")
            .end((err, res) => {
                expect(res).to.has.status(400);
                expect(res.body.Message).to.equal("The request is invalid.")
                done()
            })
    })
})

describe("Passar parâmetro errado", () => {

    it('devo receber um http status code 404', (done) => {
        request
            .get("/Version?Model=")
            .end((err, res) => {
                expect(res).to.has.status(404);
                done()
            })
    })
})






