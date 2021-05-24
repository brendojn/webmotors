import chai from 'chai'
import chaiHttp from 'chai-http'
import * as constant from '../env'

chai.use(chaiHttp)

const request = chai.request(constant.URL_API)

const expect = chai.expect

describe("Conferir modelos de veículos", () => {

    let modelChevrolet = ["Agile", "Astra", "Onix"]
    let modelHonda = ["City", "CRV", "Fit"]
    let modelFord = ["Ecosport", "Fusion"]

    it('devo validar todos os modelos para a marca chevrolet ', (done) => {
        request
            .get("/Model?MakeID=1")
            .end((err, res) => {
                expect(res).to.has.status(200);
                for (let i = 0; i < res.body.length; i++) {
                    expect(res.body[i].Name).to.equal(modelChevrolet[i]);
                }
                done()
            })
    })

    it('devo validar todos os modelos para a marca honda ', (done) => {
        request
            .get("/Model?MakeID=2")
            .end((err, res) => {
                expect(res).to.has.status(200);
                for (let i = 0; i < res.body.length; i++) {
                    expect(res.body[i].Name).to.equal(modelHonda[i]);
                }
                done()
            })
    })

    it('devo validar todos os modelos para a marca ford ', (done) => {
        request
            .get("/Model?MakeID=3")
            .end((err, res) => {
                expect(res).to.has.status(200);
                for (let i = 0; i < res.body.length; i++) {
                    expect(res.body[i].Name).to.equal(modelFord[i]);
                }
                done()
            })
    })
})

describe("Conferir o limite do id de marcas", () => {

    it('se passar um id de marca inexistente, a resposta deve ser vazia ', (done) => {
        request
            .get("/Model?MakeID=4")
            .end((err, res) => {
                expect(res).to.has.status(200);
                expect(res.body).to.empty
                done()
            })
    })

    it('se passar um id de marca 0, a resposta deve ser vazia ', (done) => {
        request
            .get("/Model?MakeID=0")
            .end((err, res) => {
                expect(res).to.has.status(200);
                expect(res.body).to.empty
                done()
            })
    })
})

describe("Não passar valor da marca", () => {

    it('devo receber uma mensagem de request inválida ', (done) => {
        request
            .get("/Model?MakeID=")
            .end((err, res) => {
                expect(res).to.has.status(400);
                expect(res.body.Message).to.equal("The request is invalid.")
                done()
            })
    })
})





